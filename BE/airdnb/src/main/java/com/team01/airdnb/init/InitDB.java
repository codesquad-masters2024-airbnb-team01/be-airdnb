package com.team01.airdnb.init;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.team01.airdnb.accommadation.Accommodation;
import com.team01.airdnb.accommadation.AccommodationRepository;
import com.team01.airdnb.amenity.Amenity;
import com.team01.airdnb.amenity.AmenityRepository;
import com.team01.airdnb.amenity.AmenityStatus;
import com.team01.airdnb.comment.Comment;
import com.team01.airdnb.comment.CommentRepository;
import com.team01.airdnb.user.Role;
import com.team01.airdnb.user.SocialType;
import com.team01.airdnb.user.User;
import com.team01.airdnb.user.UserRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class InitDB implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AccommodationRepository accommodationRepository;

  @Autowired
  private AmenityRepository amenityRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public void run(String... args) throws Exception {
    String userCsvFile = "C:\\Users\\ogt12\\OneDrive\\바탕 화면\\Codesquad\\airdnb\\BE\\airdnb\\src\\main\\resources\\excel\\userdata.csv";
    String accommodationCsvFile = "C:\\Users\\ogt12\\OneDrive\\바탕 화면\\Codesquad\\airdnb\\BE\\airdnb\\src\\main\\resources\\excel\\accommodationdata.csv";
    String amenityCsvFile = "C:\\Users\\ogt12\\OneDrive\\바탕 화면\\Codesquad\\airdnb\\BE\\airdnb\\src\\main\\resources\\excel\\amanitydata.csv";
    String commentCsvFile = "C:\\Users\\ogt12\\OneDrive\\바탕 화면\\Codesquad\\airdnb\\BE\\airdnb\\src\\main\\resources\\excel\\commentsdata.csv";
    List<User> users = readUsersFromCsv(userCsvFile);
    userRepository.saveAll(users);

    Map<Long, User> userMap = users.stream()
        .collect(Collectors.toMap(User::getId, Function.identity()));

    List<Accommodation> accommodations = readAccommodationsFromCsv(accommodationCsvFile, userMap);
    accommodationRepository.saveAll(accommodations);

    Map<Long, Accommodation> accommodationMap = accommodations.stream()
        .collect(Collectors.toMap(Accommodation::getId, Function.identity()));

    List<Amenity> amenities = readAmenitiesFromCsv(amenityCsvFile, accommodationMap);
    amenityRepository.saveAll(amenities);

    List<Comment> comments = readCommentsFromCsv(commentCsvFile, userMap, accommodationMap);
    commentRepository.saveAll(comments);
  }

  // Existing methods (readUsersFromCsv, readAccommodationsFromCsv, parseDoubleOrNull) remain unchanged

  private List<Amenity> readAmenitiesFromCsv(String csvFile, Map<Long, Accommodation> accommodationMap) throws IOException, CsvException {
    List<Amenity> amenities = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
      List<String[]> rows = reader.readAll();
      // Skip the header row
      for (int i = 1; i < rows.size(); i++) {
        String[] row = rows.get(i);
        Accommodation accommodation = accommodationMap.get(Long.parseLong(row[11]));
        Amenity amenity = Amenity.builder()
            .id(Long.parseLong(row[0]))
            .beds(Integer.parseInt(row[1]))
            .bathrooms(Integer.parseInt(row[2]))
            .kitchen(AmenityStatus.valueOf(row[3]))
            .dedicatedWorkspace(AmenityStatus.valueOf(row[4]))
            .tv(AmenityStatus.valueOf(row[5]))
            .washingMachine(AmenityStatus.valueOf(row[6]))
            .airConditioner(AmenityStatus.valueOf(row[7]))
            .wirelessInternet(AmenityStatus.valueOf(row[8]))
            .freeParking(AmenityStatus.valueOf(row[9]))
            .paidParking(AmenityStatus.valueOf(row[10]))
            .accommodation(accommodation)
            .build();
        amenities.add(amenity);
      }
    } catch (CsvException e) {
      throw new RuntimeException(e);
    }
    return amenities;
  }

  private List<User> readUsersFromCsv(String csvFile) throws IOException, CsvException {
    List<User> users = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
      List<String[]> rows = reader.readAll();
      // Skip the header row
      for (int i = 1; i < rows.size(); i++) {
        String[] row = rows.get(i);
        User user = User.builder()
            .id(Long.parseLong(row[0]))
            .username(row[1])
            .email(row[2])
            .profile(row[3])
            .role(Role.valueOf(row[4]))
            .socialType(SocialType.valueOf(row[5]))
            .socialId(row[6])
            .build();
        users.add(user);
      }
    }
    return users;
  }

  private List<Accommodation> readAccommodationsFromCsv(String csvFile, Map<Long, User> userMap) throws IOException, CsvException {
    List<Accommodation> accommodations = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
      List<String[]> rows = reader.readAll();
      // Skip the header row
      for (int i = 1; i < rows.size(); i++) {
        String[] row = rows.get(i);
        User user = userMap.get(Long.parseLong(row[13]));
        Accommodation accommodation = Accommodation.builder()
            .id(Long.parseLong(row[0]))
            .content(row[1])
            .address(row[2])
            .title(row[3])
            .longitude(parseDoubleOrNull(row[4]))
            .latitude(parseDoubleOrNull(row[5]))
            .maxAdults(Integer.parseInt(row[6]))
            .maxChildren(Integer.parseInt(row[7]))
            .maxInfants(Integer.parseInt(row[8]))
            .maxPets(Integer.parseInt(row[9]))
            .commentsNum(Integer.parseInt(row[10]))
            .discountRate(Integer.parseInt(row[11]))
            .user(user)
            .price(Long.parseLong(row[14]))
            .build();
        accommodations.add(accommodation);
      }
    }
    return accommodations;
  }

  private List<Comment> readCommentsFromCsv(String csvFile, Map<Long, User> userMap, Map<Long, Accommodation> accommodationMap) throws IOException, CsvException {
    List<Comment> comments = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
      List<String[]> rows = reader.readAll();
      // Skip the header row
      for (int i = 1; i < rows.size(); i++) {
        String[] row = rows.get(i);
        User user = userMap.get(Long.parseLong(row[4]));
        Accommodation accommodation = accommodationMap.get(Long.parseLong(row[5]));

        Comment comment = Comment.builder()
            .id(Long.parseLong(row[0]))
            .score(Double.parseDouble(row[1]))
            .content(row[2])
            .createdAt(LocalDateTime.parse(row[3], DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm")))
            .user(user)
            .accommodation(accommodation)
            .build();
        comments.add(comment);
      }
    }
    return comments;
  }

  private Double parseDoubleOrNull(String value) {
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
