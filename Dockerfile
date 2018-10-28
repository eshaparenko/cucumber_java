
FROM maven:3-alpine
MAINTAINER yshaparenko@lohika.com

# add all sources
COPY pom.xml /automation/

COPY entrypoint.sh /
RUN mkdir -p /automation/reports
RUN chmod +x /entrypoint.sh
RUN chown -R 1000:1000 /automation

WORKDIR /automation
ENTRYPOINT ["/entrypoint.sh"]