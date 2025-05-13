<details>
  <summary>🇬🇧 English</summary>

# StarlightSkinRenderer

**StarlightSkinRenderer** is a lightweight skin renderer for Minecraft 1.7/1.8 (MCP/Forge), using the [Starlight Skins API](https://starlightskins.lunareclipse.studio).  
It supports dynamic rendering of player skins with a variety of 3D poses, crop options, custom skin URLs, and automatic local caching.

---

## ✨ Features

- ✅ 24 different 3D render types (from the Starlight Skins API)
- ✅ Crop modes: `FULL`, `BUST`, `FACE`
- ✅ Works with Mojang premium skins or custom skin servers (via dynamic URL)
- ✅ Automatic scaling and centering
- ✅ Caches skins locally after first load
- ✅ Fluent Java builder API
- ✅ Compatible with Minecraft 1.7/1.8 (MCP or Forge)

---

## 🖼 Preview

> You can insert a screenshot of all rendered models in-game here:

<p align="center">
  <img src="images/preview.png" alt="StarlightSkinRenderer Preview" width="800"/>
</p>

---

## 🚀 Quick Example

```java
StarlightSkinRenderer.build()
    .name("CipheR_")
    .type(StarlightSkinRenderer.RenderType.MARCHING)
    .crop(StarlightSkinRenderer.CropType.FULL)
    .customSkinUrl("https://yourwebsite.com/skins/{{username}}")
    .at(this.width / 2f, this.height / 2f)
    .scale(150f)
    .center(true)
    .draw();
```

✅ You can replace `customSkinUrl` with your own CMS or skin system.  
Use `{{username}}` as a placeholder for the player's name.

---

## 🧱 Supported Render Types

```
CLOWN, HIGH_GROUND, READING, MOJAVATAR, KICKING, ARCHER, DEAD, SLEEPING,
FACEPALM, DUNGEONS, LUNGING, POINTING, COWERING, TRUDGING, RELAXING,
CHEERING, HEAD, ISOMETRIC, ULTIMATE, CRISS_CROSS, WALKING, MARCHING, DEFAULT
```

> ⚠ Some types support only specific crop modes:  
> - `HEAD` → `FULL` only  
> - `SLEEPING`, `MOJAVATAR` → `FULL`, `BUST` only

---

### 🧠 Automatic Caching

Once downloaded, skins are cached in memory and reused without any additional requests.

---

## 📦 Installation

This is a standalone Java class that can be dropped directly into an MCP or Forge project.  
Tested with Minecraft **1.7.10**, and compatible with 1.8 and 1.9+ with small adjustments.

---

## 🧑‍💻 License

Released under the **MIT License**.  
Free to use in mods, GUIs, launchers, or any other project.

---

## 🙏 Credits

- Powered by the [Starlight Skins API](https://starlightskins.lunareclipse.studio)
- Inspired by modern 3D skin previews like Lunar Client and SkinsRestorer

</details>

<details open>
  <summary>🇫🇷 Français</summary>

# StarlightSkinRenderer

**StarlightSkinRenderer** est un moteur de rendu de skins léger pour Minecraft 1.7/1.8 (MCP/Forge), utilisant l'API [Starlight Skins](https://starlightskins.lunareclipse.studio).  
Il prend en charge le rendu dynamique de skins dans une variété de poses 3D, avec des options de recadrage, une URL personnalisée et une mise en cache locale automatique.

---

## ✨ Fonctionnalités

- ✅ 24 types de rendu 3D différents (issus de l'API Starlight)
- ✅ Recadrages : `FULL`, `BUST`, `FACE`
- ✅ Support des skins premium ou personnalisés (via une URL dynamique)
- ✅ Mise à l’échelle automatique et centrage
- ✅ Mise en cache locale après le premier chargement
- ✅ API fluide avec un builder Java
- ✅ Conçu pour Minecraft 1.7/1.8 sous MCP ou Forge

---

## 🖼 Aperçu

> Insérez ici une capture d’écran de tous les modèles affichés en jeu :

<p align="center">
  <img src="images/preview.png" alt="Aperçu du rendu StarlightSkinRenderer" width="800"/>
</p>

---

## 🚀 Exemple rapide

```java
StarlightSkinRenderer.build()
    .name("CipheR_")
    .type(StarlightSkinRenderer.RenderType.MARCHING)
    .crop(StarlightSkinRenderer.CropType.FULL)
    .customSkinUrl("https://votresite.com/skins/{{username}}")
    .at(this.width / 2f, this.height / 2f)
    .scale(150f)
    .center(true)
    .draw();
```

✅ Vous pouvez remplacer `customSkinUrl` par votre propre système de skins.  
Utilisez `{{username}}` comme variable pour le pseudo du joueur.

---

## 🧱 Types de rendu supportés

```
CLOWN, HIGH_GROUND, READING, MOJAVATAR, KICKING, ARCHER, DEAD, SLEEPING,
FACEPALM, DUNGEONS, LUNGING, POINTING, COWERING, TRUDGING, RELAXING,
CHEERING, HEAD, ISOMETRIC, ULTIMATE, CRISS_CROSS, WALKING, MARCHING, DEFAULT
```

> ⚠ Certains types de rendu ne prennent en charge que certains recadrages :  
> - `HEAD` → uniquement `FULL`  
> - `SLEEPING`, `MOJAVATAR` → `FULL`, `BUST` uniquement

---

### 🧠 Mise en cache automatique

Une fois le skin téléchargé, il est stocké en mémoire et réutilisé sans redemande réseau.

---

## 📦 Installation

Cette classe est indépendante et peut être copiée directement dans un projet MCP ou Forge.  
Testé avec succès sur Minecraft **1.7.10**, compatible 1.8 et 1.9+ avec quelques ajustements.

---

## 🧑‍💻 Licence

Distribué sous licence **MIT**.  
Libre pour l'utilisation dans vos mods, GUIs ou autres projets.

---

## 🙏 Remerciements

- Propulsé par l'API [Starlight Skins](https://starlightskins.lunareclipse.studio)
- Inspiré des aperçus 3D modernes de skins type Lunar Client ou SkinsRestorer

</details>
