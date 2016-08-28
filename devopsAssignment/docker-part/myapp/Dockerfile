FROM ubuntu:14.04

COPY  . /usr/src/myapp

WORKDIR /usr/src/myapp

RUN apt-get update

RUN apt-get install -y g++

RUN g++ -o myapp restaurantRecommendationProgram.cpp

CMD ["./myapp","sample_data.csv","burger"]