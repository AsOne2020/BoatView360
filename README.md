# BoatView360

[🌏 简体中文](README.md)  |  [🌐 English](README_en.md)

[![Fabric](https://img.shields.io/badge/Mod%20Loader-Fabric-lightyellow)](https://fabricmc.net/)
[![Forge](https://img.shields.io/badge/Mod%20Loader-Forge-orange)](https://files.minecraftforge.net/)
[![NeoForge](https://img.shields.io/badge/Mod%20Loader-NeoForge-ff6600)](https://neoforged.net/)
[![MC Versions](http://cf.way2muchnoise.eu/versions/For%20MC_BoatView360_all.svg)](https://curseforge.com/minecraft/mc-mods/BoatView360)
[![CurseForge](http://cf.way2muchnoise.eu/full_BoatView360_downloads.svg)](https://curseforge.com/minecraft/mc-mods/BoatView360)
[![Modrinth](https://img.shields.io/modrinth/dt/BoatView360?color=00AF5C&logo=modrinth)](https://modrinth.com/mod/BoatView360)

## 介绍

**BoatView360** 是一款 Minecraft 的 Fabric / Forge / NeoForge 模组，移除船上乘客视角旋转限制（210°），让玩家在船上能够进行 **360° 视角旋转**。

在原版 Minecraft 中，玩家在船上时视角旋转限制在 ±105°以内，这会影响玩家观察周围环境的体验。本模组移除了该限制，使玩家在船上能够自由环顾四周。

## 特性

- 移除船上玩家视角旋转限制，支持完整 360° 自由旋转
- 兼容以下模组：
  - [Immersive Aircraft](https://modrinth.com/mod/immersive-aircraft)
  - [Immersive Machinery](https://modrinth.com/mod/immersive-machinery)
  - [Piggybacks](https://modrinth.com/mod/piggybacks)

## 使用说明

- **客户端（必需）**  
  本模组**必须**安装在客户端，才能实现船上无限制的 360° 视角旋转。

- **服务端（可选）**  
  服务端可以选择是否安装本模组。  
  不过，为了多人游戏中所有玩家都能看到正确的 360° 头部旋转，建议三方均安装本模组：
  - 你的客户端
  - 其他玩家的客户端
  - 服务端

若三方中任意一方未安装本模组，360° 旋转效果将无法同步，其他玩家仍会看到你的头部旋转角度受限于原版的 ±105° 范围内。

## 致谢

感谢以下项目：

- [fabric-mod-template](https://github.com/Fallen-Breath/fabric-mod-template)
- [stonecutter-template-fabric](https://github.com/stonecutter-versioning/stonecutter-template-fabric)
