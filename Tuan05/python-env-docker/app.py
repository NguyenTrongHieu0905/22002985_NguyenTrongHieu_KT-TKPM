import os

# Đọc biến môi trường APP_ENV, mặc định là 'production' nếu không được đặt
app_env = os.getenv("APP_ENV", "production")

print(f"Ứng dụng đang chạy trong môi trường: {app_env}")
