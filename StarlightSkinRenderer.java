package fr.cipher.api.skins;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * StarlightSkinRenderer is a lightweight MCP/Forge 1.7/1.8 skin renderer using the Starlight Skins API.
 * Supports various 3D render styles and crops, with dynamic URL rendering and local caching.
 */
public class StarlightSkinRenderer {

    // === Available skin crop types ===
    public enum CropType {
        FULL, BUST, FACE
    }

    // === Available 3D render styles supported by the API ===
    public enum RenderType {
        CLOWN, HIGH_GROUND, READING, MOJAVATAR, KICKING, ARCHER, DEAD, SLEEPING,
        FACEPALM, DUNGEONS, LUNGING, POINTING, COWERING, TRUDGING, RELAXING,
        CHEERING, HEAD, ISOMETRIC, ULTIMATE, CRISS_CROSS, WALKING, MARCHING, DEFAULT;

        /**
         * Defines which crop types are allowed for this render style.
         */
        public Set<CropType> getSupportedCrops() {
            switch (this) {
                case MOJAVATAR:
                case SLEEPING:
                    return EnumSet.of(CropType.FULL, CropType.BUST);
                case HEAD:
                    return EnumSet.of(CropType.FULL);
                default:
                    return EnumSet.allOf(CropType.class);
            }
        }
    }

    // === Immutable rendering configuration ===
    public static final class Config {
        public final String username;
        public final RenderType renderType;
        public final CropType cropType;
        public final String baseUrl;
        public final float x, y, size;
        public final String skinUrl;
        public final boolean centered;

        private Config(String username, RenderType renderType, CropType cropType,
                        String baseUrl, float x, float y, float size,
                        String skinUrl, boolean centered) {
            this.username = username;
            this.renderType = renderType;
            this.cropType = cropType;
            this.baseUrl = baseUrl;
            this.x = x;
            this.y = y;
            this.size = size;
            this.skinUrl = skinUrl;
            this.centered = centered;
        }
    }

    // === Fluent Builder Pattern ===
    public static class Builder {
        private String username = "";
        private RenderType renderType = RenderType.DEFAULT;
        private CropType cropType = CropType.FULL;
        private String baseUrl = "https://starlightskins.lunareclipse.studio";
        private float x = 0, y = 0, size = 64;
        private String skinUrl = null;
        private boolean centered = false;

        public Builder name(String username) {
            this.username = username;
            return this;
        }

        public Builder type(RenderType type) {
            this.renderType = type;
            return this;
        }

        public Builder crop(CropType crop) {
            this.cropType = crop;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder at(float x, float y) {
            this.x = x;
            this.y = y;
            return this;
        }

        public Builder scale(float size) {
            this.size = size;
            return this;
        }

        public Builder customSkinUrl(String skinUrl) {
            this.skinUrl = skinUrl;
            return this;
        }

        public Builder center(boolean enabled) {
            this.centered = enabled;
            return this;
        }

        /**
         * Builds and renders the skin.
         */
        public void draw() {
            if (!renderType.getSupportedCrops().contains(cropType)) {
                System.err.println("Crop type " + cropType + " is not supported by render type " + renderType);
                return;
            }
            Config config = new Config(username, renderType, cropType, baseUrl, x, y, size, skinUrl, centered);
            StarlightSkinRenderer.draw(config);
        }
    }

    /**
     * Starts a new skin render builder.
     */
    public static Builder build() {
        return new Builder();
    }

    // === Internal cache object ===
    private static class CachedSkin {
        final ResourceLocation texture;
        final float height;

        CachedSkin(ResourceLocation texture, float height) {
            this.texture = texture;
            this.height = height;
        }
    }

    // === Texture cache ===
    private static final Map<String, CachedSkin> textureCache = new HashMap<>();

    // === Core draw logic ===
    private static void draw(Config config) {
        Minecraft mc = Minecraft.getMinecraft();
        String url = buildUrl(config);

        try {
            CachedSkin cached = textureCache.get(url);
            if (cached != null) {
                float drawX = config.centered ? config.x - config.size / 2f : config.x;
                float drawY = config.centered ? config.y - cached.height / 2f : config.y;
                mc.getTextureManager().bindTexture(cached.texture);
                GL11.glColor4f(1, 1, 1, 1);
                drawQuad(drawX, drawY, config.size, cached.height);
                return;
            }

            BufferedImage img = downloadImage(url);
            if (img == null) return;

            float ratio = (float) img.getHeight() / img.getWidth();
            float height = config.size * ratio;

            DynamicTexture tex = new DynamicTexture(img);
            ResourceLocation texture = mc.getTextureManager().getDynamicTextureLocation("skin_" + config.username, tex);
            textureCache.put(url, new CachedSkin(texture, height));

            float drawX = config.centered ? config.x - config.size / 2f : config.x;
            float drawY = config.centered ? config.y - height / 2f : config.y;

            mc.getTextureManager().bindTexture(texture);
            GL11.glColor4f(1, 1, 1, 1);
            drawQuad(drawX, drawY, config.size, height);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String buildUrl(Config config) {
        String url = String.format("%s/render/%s/%s/%s",
                config.baseUrl,
                config.renderType.name().toLowerCase(),
                config.username,
                config.cropType.name().toLowerCase());

        if (config.skinUrl != null && !config.skinUrl.isEmpty()) {
            String fullSkinUrl = config.skinUrl.replace("{{username}}", config.username);
            url += "?skinUrl=" + fullSkinUrl;
        }

        return url;
    }

    private static BufferedImage downloadImage(String url) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setDoInput(true);
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        try (InputStream in = conn.getInputStream()) {
            return ImageIO.read(in);
        } finally {
            conn.disconnect();
        }
    }

    private static void drawQuad(float x, float y, float width, float height) {
        Tessellator t = Tessellator.instance;
        t.startDrawingQuads();
        t.addVertexWithUV(x,         y + height, 0, 0, 1);
        t.addVertexWithUV(x + width, y + height, 0, 1, 1);
        t.addVertexWithUV(x + width, y,          0, 1, 0);
        t.addVertexWithUV(x,         y,          0, 0, 0);
        t.draw();
    }
}