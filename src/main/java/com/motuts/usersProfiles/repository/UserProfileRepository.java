package com.motuts.usersProfiles.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.motuts.usersProfiles.entity.UserProfile;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserProfileRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public UserProfile save(UserProfile userProfile) {
        dynamoDBMapper.save(userProfile);
        return userProfile;
    }

    public UserProfile findById(String id) {
        return dynamoDBMapper.load(UserProfile.class, id);
    }

    public List<UserProfile> findAll() {
        return dynamoDBMapper.scan(UserProfile.class, new DynamoDBScanExpression());
    }

    public UserProfile update(String id, UserProfile userProfile) {
        dynamoDBMapper.save(userProfile,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));

        return userProfile;
    }

    public String delete(String id) {
        dynamoDBMapper.delete(id);
        return "UserProfile Deleted successfully: " + id;
    }
}
