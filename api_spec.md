# ユーザーAPI仕様書

## エンドポイント一覧

| メソッド | パス | 説明 |
|:---|:---|:---|
| POST | /users | ユーザー登録 |
| GET | /users | ユーザー一覧取得 |
| GET | /users/{id} | 特定ユーザー詳細取得 |
| PUT | /users/{id} | 特定ユーザー情報更新 |
| DELETE | /users/{id} | 特定ユーザー削除 |

---

## 詳細設計

### POST /users

- 機能：新規ユーザー登録
- リクエストボディ例：

```json
{
  "name": "test user",
  "email": "test@example.com",
  "password": "password123"
}

- レスポンス例（201 Created）：
{
  "id": 1,
  "name": "test user",
  "email": "test@example.com",
  "createdAt": "2025-04-09T12:00:00"
}
