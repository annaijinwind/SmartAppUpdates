package com.annaijin.smartupdates;

import com.annaijin.smartupdates.pathnative.PatchUtils;

/**
 * Created by WP-FENGJQ on 2018/2/22.
 */

public class AppPatchUtils {
    public static void getNewApk(String oldApkPath, String newApkPath,
                                 String patchPath){
        PatchUtils.getNewApk(oldApkPath,newApkPath,patchPath);
    }
}
