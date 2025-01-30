package com.example.evoting.common;

public class XSSSanitizer {
	// 使用正則表達式清除所有 HTML 標籤
    public static String sanitize(String input) {
        // 使用正則表達式移除所有 HTML 標籤
        return input.replaceAll("<[^>]*>", "");
    }
}
