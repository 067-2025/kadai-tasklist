package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Content;

public class ContentValidator {
    // バリデーションを実行する
    public static List<String> validate(Content c) {
        List<String> errors = new ArrayList<String>();

        String content_error = validateContent(c.getContent());
        if (!content_error.equals("")) {
            errors.add(content_error);
        }

        return errors;
    }

    // タスクの必須入力チェック
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return "タスクを入力してください。";
        }

        return "";
    }
}
