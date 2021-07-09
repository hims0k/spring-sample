package com.example.springsample.utils;

import com.google.common.base.CaseFormat;
import lombok.NonNull;

/**
 * 文字列を変換するためのユーティリティクラス
 */
public class CaseFormatUtils {

    public static String lCamelToLSnake(String src) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, src);
    }
}
