# Stage 1: Build code
FROM node:18 AS build

WORKDIR /app

# Copy package.json và cài đặt dependencies
COPY package.json package-lock.json ./
RUN npm install --only=production

# Copy toàn bộ source code vào container
COPY . .

# Stage 2: Chạy ứng dụng
FROM node:18-alpine

WORKDIR /app

# Copy code từ stage build
COPY --from=build /app /app

# Mở cổng 3000
EXPOSE 3000

# Chạy ứng dụng
CMD ["npm", "start"]


