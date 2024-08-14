<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <img src="https://s1.imagehub.cc/images/2023/03/07/af8ed087c9d354b9ab6142aae7bbafb6.png" alt="autojs6-banner_800×224" border="0" width="704" />
  </p>

  <p>Android 平台支持无障碍服务的 JavaScript 自动化工具</p>

</div>

******

### 简介

******

[Auto.js](https://github.com/hyb1996/Auto.js) 是一款 Android 平台支持 [无障碍服务](https://developer.android.com/guide/topics/ui/accessibility/service?hl=zh-cn) 的 JavaScript 自动化工具软件.

Auto.js 由 [hyb1996](https://github.com/hyb1996) 于 `2017/01/27` 初次发布, 于 `2020/03/13` 停止维护, 最终版本名称为 `4.1.1 Alpha2`, 构建版本号为 `461`.

AutoJsEx 在 Auto.js 最终项目的基础上,  进行二次开发, 继续保持开源免费.

******

### 功能

******

* 可用作 JavaScript IDE (代码补全/变量重命名/代码格式化)
* 支持基于 [无障碍服务](https://developer.android.com/reference/android/accessibilityservice/AccessibilityService) 的自动化操作
* 支持浮动按钮快捷操作 (脚本录制及运行/查看包名及活动/布局分析)
* 支持选择器 API 并提供控件遍历/获取信息/控件操作 (类似 [UiAutomator](https://developer.android.com/training/testing/ui-automator))
* 支持布局界面分析 (类似 Android Studio 的 LayoutInspector)
* 支持录制功能及录制回放
* 支持屏幕截图/保存截图/图片找色/图片匹配
* 支持 [E4X](https://zh.wikipedia.org/wiki/E4X) (ECMAScript for XML) 编写界面
* 支持将脚本文件或项目打包为 APK 文件
* 支持利用 Root 权限扩展功能 (屏幕点击/滑动/录制/Shell)
* 支持作为 Tasker 插件使用
* 支持与 VSCode 连接并进行桌面开发 (需要 [AutoJs6-VSCode-Extension](http://vscext-project.autojs6.com) 插件)

******

### 环境

******

- Android 操作系统
- [API](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels) [24](https://developer.android.com/reference/android/os/Build.VERSION_CODES#N) ([7.0](https://zh.wikipedia.org/wiki/Android_Nougat)) [[N](https://developer.android.com/reference/android/os/Build.VERSION_CODES#N)] 及以上

******

### 指南

******

* [项目编译构建](#项目编译构建)
* [脚本开发辅助](#脚本开发辅助)

******

### 主要变更

******

* 优化连接手机传文件时卡顿，以及残留等问题

* VSCode 插件支持客户端 (LAN) 及服务端 (LAN/ADB) 连接方式

* 多语言适配 (西/法/俄/阿/日/韩/英/简中/繁中等)

* 夜间模式适配 (设置页面/文档页面/布局分析页面/浮动窗口等)

* [Rhino](https://github.com/mozilla/rhino/) 引擎由 [v1.7.7.2](https://github.com/mozilla/rhino/releases/tag/Rhino1_7_7_2_Release) 升级至 [v1.7.15-SNAPSHOT](http://rhino.autojs6.com/blob/dbe3f43ba5eb01e7f76139208f36c383dcd1c488/gradle.properties#L3)

    * 支持 [Object.values()](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Object/values)

       ```javascript
       Object.values({name: 'Max', age: 4}); // ['max', 4]
       ```

    * 支持 [Array.prototype.includes()](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Array/includes)

       ```javascript
       [10, 20, NaN].includes(20); // true
       ```

    * 支持 [BigInt](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/BigInt)

       ```javascript
       typeof 567n === 'bigint'; // true
       ```

    * 支持 [模板字符串](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Template_literals)

       ```javascript
       `Lucky number: ${(Math.random() * 100).toFixed(0)}`
       ```

    * 查看 Rhino 引擎 [更多新特性](http://project.autojs6.com/blob/master/app/src/main/assets/doc/RHINO.md)

    * 查看 Rhino 引擎 [兼容性列表](https://mozilla.github.io/rhino/compat/engines.html)

******

### 项目编译构建

******

如需对项目进行调试或开发, 可使用 Android Studio 或 [IntelliJ IDEA](https://www.jetbrains.com/idea/) ([Jetbrains](https://www.jetbrains.com/) 公司产品).

本小节以 Android Studio 为例介绍 AutoJs6 开源项目的编译构建方法, IntelliJ IDEA 与之类似.

#### Android Studio 准备

下载 `Android Studio Hedgehog | 2023.1.1` 版本 (按需选择其一):

- [android-studio-2023.1.1.26-windows.exe](https://redirector.gvt1.com/edgedl/android/studio/install/2023.1.1.26/android-studio-2023.1.1.26-windows.exe) (1.1 GB)
- [android-studio-2023.1.1.26-windows.zip](https://redirector.gvt1.com/edgedl/android/studio/ide-zips/2023.1.1.26/android-studio-2023.1.1.26-windows.zip) (1.1 GB)

> 注: 上述版本发布时间为 2023 年 11 月 30 日. 如需下载其他版本, 或上述链接已失效, 可访问 [Android Studio 发行版本归档](https://developer.android.com/studio/archive?hl=en) 页面.

安装或解压上述文件, 运行 Android Studio 软件 (如 `"D:\android-studio\bin\studio64.exe"`).

#### Android SDK 准备

> 注: 如果计算机系统已安装 Android SDK (安卓软件开发工具包), 则可跳过此小节内容.

在 Android Studio 软件中使用快捷键 `CTRL + ALT + S` 打开设置页面:

```text
Appearance & Behavior (外观与表现) -> 
System Settings (系统设置) -> 
Android SDK (安卓软件开发工具包)
```

`Android SDK Location (安卓软件开发工具包位置)` 处如果是空白内容, 可点击右侧 `Edit (编辑)` 按钮, 在弹出的窗口中多次点击 `Next (下一步)`.

> 注: 过程中可能需要同意一个或多个相关协议才能继续.

待相关资源下载并安装完毕, 点击 `Finish (完成)` 按钮.  
上述 `Android SDK Location (安卓软件开发工具包位置)` 处将自动完成路径填写, SDK 准备工作随即完成.

#### Android SDK Tools 准备

AutoJs6 需要使用部分 SDK 工具 (如 NDK 及 CMake).

> 注: 如果计算机系统已安装 AutoJs6 全部所需的 Android SDK Tools, 则可跳过此小节内容.

在 Android Studio 软件中使用快捷键 `CTRL + ALT + S` 打开设置页面:

```text
Appearance & Behavior (外观与表现) -> 
System Settings (系统设置) -> 
Android SDK (安卓软件开发工具包) -> 
SDK Tools (SDK 工具) (位于右侧窗口)
```

勾选 `Show Package Details (显示包详情)`, 依次点击 NDK 及 CMake, 确保相应版本的工具已勾选 (截至 2023 年 10 月 30 日, NDK 所需版本为 `21.1.6352462`, CMake 所需版本为 `3.10.2`).

SDK 工具的版本信息位于 AutoJs6 项目根目录的 `version.properties` 文件中.

