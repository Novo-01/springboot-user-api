# ユーザーエンティティ設計

## usersテーブル

| カラム名 | 型 | 制約 | 説明 |
|:---|:---|:---|:---|
| id | BIGINT | PRIMARY KEY, AUTO_INCREMENT | ユーザーID |
| name | VARCHAR(100) | NOT NULL | ユーザー名 |
| email | VARCHAR(255) | UNIQUE, NOT NULL | メールアドレス |
| password | VARCHAR(255) | NOT NULL | ハッシュ化されたパスワード |
| created_at | DATETIME | DEFAULT CURRENT_TIMESTAMP | 登録日時 |
| updated_at | DATETIME | DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP | 更新日時 |
