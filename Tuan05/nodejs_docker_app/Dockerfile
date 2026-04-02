# S? d?ng node:18 l…m base image
FROM node:18

# Thi?t l?p thu m?c l…m vi?c trong container
WORKDIR /app

# Sao ch‚p package.json v… package-lock.json v…o container
COPY package*.json ./

# C…i d?t c c dependencies
RUN npm install

# Sao ch‚p to…n b? ma ngu?n v…o container
COPY . .

# M? c?ng 3000
EXPOSE 3000

# Kh?i d?ng ?ng d?ng
CMD ["node", "app.js"]