# Sử dụng Go làm base image
FROM golang:latest

# Đặt thư mục làm việc trong container
WORKDIR /app

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Biên dịch ứng dụng Go thành file thực thi
RUN go build -o main .

# Mở cổng 8080
EXPOSE 8080

# Chạy ứng dụng Go
CMD ["./main"]
