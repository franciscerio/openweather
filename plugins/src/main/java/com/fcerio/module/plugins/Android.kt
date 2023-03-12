package com.fcerio.module.plugins

object Android {
    private const val versionMajor = 0
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionBuild = 1 // bump for dogfood builds, public betas, etc.

    const val VERSION_CODE =
        versionMajor * 10000 + versionMinor * 1000 + versionPatch * 10 + versionBuild
    const val VERSION_NAME = "$versionMajor.$versionMinor.$versionPatch"

}
