FROM ubuntu:14.04

COPY  . /usr/src/myapp

WORKDIR /usr/src/myapp

RUN apt-get update \
	&& apt-get install -y g++ \
	&& g++ -o myapp restaurantRecommendationProgram.cpp
 
CMD ["./myapp","sample_data.csv","burger"]
