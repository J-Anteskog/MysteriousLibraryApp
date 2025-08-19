# Patchar Android-autolinking.cmake så att varje add_subdirectory skyddas av if(EXISTS ...)
$cmakeFile = "C:\Users\Antes\AndroidStudioProjects\MysteriousLibraryApp\android\app\build\generated\autolinking\src\main\jni\Android-autolinking.cmake"

if (Test-Path $cmakeFile) {
    $lines = Get-Content $cmakeFile
    $newLines = @()
    foreach ($line in $lines) {
        if ($line -match '^add_subdirectory\("(.+?)"\s+(.+?)\)') {
            $dir = $Matches[1]
            $target = $Matches[2]
            $newLines += 'if(EXISTS "' + $dir + '")'
            $newLines += '  add_subdirectory("' + $dir + '" ' + $target + ')'
            $newLines += 'endif()'
        } else {
            $newLines += $line
        }
    }
    $newLines | Set-Content $cmakeFile -Encoding UTF8
    Write-Host "Patchad: $cmakeFile"
} else {
    Write-Host "Filen hittades inte: $cmakeFile"
}
