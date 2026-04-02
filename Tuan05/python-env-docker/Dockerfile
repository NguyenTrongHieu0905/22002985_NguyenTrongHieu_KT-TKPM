# Sử dụng Python 3.9 làm base image
FROM python:3.9

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép mã nguồn vào container
COPY . .

# Thiết lập biến môi trường
ENV APP_ENV=development

# Chạy ứng dụng
CMD ["python", "app.py"]
