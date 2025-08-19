$packageList = "android\app\build\generated\autolinking\src\main\java\com\facebook\react\PackageList.java"
if (Test-Path $packageList) {
    (Get-Content $packageList) |
        Where-Object { $_ -notmatch "ExpoModulesPackage" } |
        Set-Content $packageList
    Write-Host "Patched PackageList.java to remove ExpoModulesPackage."
} else {
    Write-Host "PackageList.java not found."
}