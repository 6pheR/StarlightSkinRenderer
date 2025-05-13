<details>
  <summary>🇬🇧 English</summary>

# StarlightSkinRenderer

**StarlightSkinRenderer** is a lightweight skin renderer for Minecraft 1.7/1.8 (MCP/Forge), using the [Starlight Skins API](https://starlightskins.lunareclipse.studio).  
It dynamically fetches and renders player skins in various 3D poses by querying the API, supporting both Mojang premium skins and custom skin servers.

---

## ✨ Features

- ✅ 24 different 3D render types (from the Starlight Skins API)
- ✅ Crop modes: `FULL`, `BUST`, `FACE`
- ✅ Works with Mojang premium skins or custom skin servers (via dynamic URL)
- ✅ Automatic scaling, centering, and validation
- ✅ Fully asynchronous image downloads (non-blocking)
- ✅ Advanced caching with expiration and memory management
- ✅ Detailed logs for debugging and error tracking
- ✅ Fluent Java builder API
- ✅ Compatible with Minecraft 1.7/1.8 (MCP or Forge)
- ✅ Standalone, single-class implementation (drop it in and use!)

---

## 🖼 Preview

<p align="center">
  <img src="images/preview.png" alt="StarlightSkinRenderer Preview" width="800"/>
</p>

---

## 🚀 Quick Example

```java
StarlightSkinRenderer.builder()
    .username("CipheR_") // Minecraft username or custom API name
    .renderType(StarlightSkinRenderer.RenderType.MARCHING)
    .cropType(StarlightSkinRenderer.CropType.FULL)
    .customSkinUrl("https://yourwebsite.com/skins/{{username}}") // Optional for custom skin APIs
    .position(100f, 200f)
    .scale(150f)
    .centered(true)
    .render();
```

✅ If using `customSkinUrl`, replace it with your own skin API.  
Use `{{username}}` as a placeholder for the player's name.

---

## 🧱 How It Works

1. **Fetches Skins Dynamically**:  
   The class queries the [Starlight Skins API](https://starlightskins.lunareclipse.studio) to fetch a generated image of the player's skin in the specified pose and crop. You can use Mojang's premium skin system or your own custom API for skins.

2. **Supports 3D Poses and Crops**:  
   Choose from 24 3D poses and 3 crop modes (`FULL`, `BUST`, or `FACE`) to render your skin.

3. **Asynchronous and Cached**:  
   Skins are downloaded asynchronously to avoid blocking the game and cached in memory for faster subsequent loads.

---

## 🧱 Supported Render Types

```text
CLOWN, HIGH_GROUND, READING, MOJAVATAR, KICKING, ARCHER, DEAD, SLEEPING,
FACEPALM, DUNGEONS, LUNGING, POINTING, COWERING, TRUDGING, RELAXING,
CHEERING, HEAD, ISOMETRIC, ULTIMATE, CRISS_CROSS, WALKING, MARCHING, DEFAULT
```

> ⚠ Some types support only specific crop modes:  
> - `HEAD` → `FULL` only  
> - `SLEEPING`, `MOJAVATAR` → `FULL`, `BUST` only

---

### 🧠 Advanced Caching

- **How it works**: Skins are downloaded once and cached in memory, with automatic expiration after 10 minutes.
- **Memory efficiency**: Expired skins are automatically removed from the cache.

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
Il génère dynamiquement une image du skin d'un joueur dans une pose 3D spécifiée, en interrogeant l'API. Il prend en charge les skins premium Mojang ainsi que des serveurs de skins personnalisés.

---

## ✨ Fonctionnalités

- ✅ 24 types de rendu 3D différents (issus de l'API Starlight)
- ✅ Recadrages : `FULL`, `BUST`, `FACE`
- ✅ Support des skins premium ou personnalisés (via une URL dynamique)
- ✅ Mise à l’échelle automatique, centrage et validation
- ✅ Téléchargements d'images entièrement asynchrones (sans blocage)
- ✅ Mise en cache avancée avec expiration et gestion mémoire
- ✅ Logs détaillés pour le débogage et le suivi des erreurs
- ✅ API fluide avec un builder Java
- ✅ Compatible avec Minecraft 1.7/1.8 sous MCP ou Forge
- ✅ Implémentation autonome en une seule classe (simple à intégrer)

---

## 🖼 Aperçu

<p align="center">
  <img src="images/preview.png" alt="Aperçu du rendu StarlightSkinRenderer" width="800"/>
</p>

---

## 🚀 Exemple rapide

```java
StarlightSkinRenderer.builder()
    .username("CipheR_") // Nom d'utilisateur Minecraft ou API personnalisée
    .renderType(StarlightSkinRenderer.RenderType.MARCHING)
    .cropType(StarlightSkinRenderer.CropType.FULL)
    .customSkinUrl("https://votresite.com/skins/{{username}}") // Optionnel pour des APIs personnalisées
    .position(100f, 200f)
    .scale(150f)
    .centered(true)
    .render();
```

✅ Vous pouvez remplacer `customSkinUrl` par votre propre API de skins.  
Utilisez `{{username}}` comme variable pour le pseudo du joueur.

---

## 🧱 Comment ça marche

1. **Téléchargement dynamique des skins** :  
   La classe interroge l'[API Starlight Skins](https://starlightskins.lunareclipse.studio) pour générer une image du skin du joueur dans la pose et le recadrage spécifiés. Vous pouvez utiliser le système Mojang ou une API personnalisée.

2. **Support des poses 3D et des recadrages** :  
   Choisissez parmi 24 poses 3D et 3 recadrages (`FULL`, `BUST` ou `FACE`) pour afficher votre skin.

3. **Asynchrone et mis en cache** :  
   Les skins sont téléchargés de manière asynchrone pour éviter de bloquer le jeu et mis en cache en mémoire pour des chargements ultérieurs plus rapides.

---

## 🧱 Types de rendu supportés

```text
CLOWN, HIGH_GROUND, READING, MOJAVATAR, KICKING, ARCHER, DEAD, SLEEPING,
FACEPALM, DUNGEONS, LUNGING, POINTING, COWERING, TRUDGING, RELAXING,
CHEERING, HEAD, ISOMETRIC, ULTIMATE, CRISS_CROSS, WALKING, MARCHING, DEFAULT
```

> ⚠ Certains types de rendu ne prennent en charge que certains recadrages :  
> - `HEAD` → uniquement `FULL`  
> - `SLEEPING`, `MOJAVATAR` → `FULL`, `BUST` uniquement

---

### 🧠 Mise en cache avancée

- **Comment ça marche** : Les skins sont téléchargés une fois et mis en cache en mémoire. Ils expirent automatiquement après 10 minutes.
- **Efficacité mémoire** : Les skins expirés sont automatiquement supprimés du cache.

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
