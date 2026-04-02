# Sử dụng Python 3.9 làm base image
FROM python:3.9

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép file vào container
COPY . .

# Cài đặt thư viện cần thiết
RUN pip install -r requirements.txt

# Mở cổng 5000
EXPOSE 5000

# Chạy ứng dụng Flask
CMD ["python", "app.py"]

