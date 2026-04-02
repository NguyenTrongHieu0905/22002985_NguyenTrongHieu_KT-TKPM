# Sử dụng Node.js 18 Alpine làm base image
FROM node:18-alpine

# Đặt thư mục làm việc bên trong container
WORKDIR /app

# Sao chép package.json và package-lock.json vào container
COPY package*.json ./

# Cài đặt các dependency
RUN npm install

# Sao chép toàn bộ mã nguồn vào container
COPY . .

# Build ứng dụng
RUN npm run build

# Mở cổng 3000
EXPOSE 3000

# Chạy ứng dụng React
CMD ["npm", "start"]
