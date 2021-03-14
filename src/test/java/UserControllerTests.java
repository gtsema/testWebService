import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.example.controllers.UserController;
import ru.example.model.User;
import ru.example.service.UserService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTests {

    private int autoChangeDelaySec;

    @BeforeAll
    public void setUp() {
        autoChangeDelaySec = 300;
    }

    @Test
    @DisplayName("statusAutoChange_lessTimeForSwitchOnline_onlineUserStatus")
    public void statusAutoChange_lessTimeForSwitchOnline() {
        User correctUser = getNewCorrectUser();
        long currentTime = Calendar.getInstance().getTime().getTime();
        Date halfDelayTime = new Date(currentTime - autoChangeDelaySec*1000/2);
        correctUser.setLastActivity(halfDelayTime);
        correctUser.setStatus(User.Status.Online);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        try {
            Field autoChangeDelaySecField = UserController.class.getDeclaredField("autoChangeDelaySec");
            autoChangeDelaySecField.setAccessible(true);
            autoChangeDelaySecField.setInt(userController, autoChangeDelaySec);

            Method method = UserController.class.getDeclaredMethod("statusAutoChange", User.class);
            method.setAccessible(true);
            method.invoke(userController, correctUser);

            assertEquals(User.Status.Online, correctUser.getStatus());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            fail();
        }
    }

    @Test
    @DisplayName("statusAutoChange_moreTimeForSwitchOnline_awayUserStatus")
    public void statusAutoChange_moreTimeForSwitchOnline() {
        User correctUser = getNewCorrectUser();
        long currentTime = Calendar.getInstance().getTime().getTime();
        Date doubleDelayTime = new Date(currentTime - autoChangeDelaySec*1000*2);
        correctUser.setLastActivity(doubleDelayTime);
        correctUser.setStatus(User.Status.Online);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        try {
            Field autoChangeDelaySecField = UserController.class.getDeclaredField("autoChangeDelaySec");
            autoChangeDelaySecField.setAccessible(true);
            autoChangeDelaySecField.setInt(userController, autoChangeDelaySec);

            Method method = UserController.class.getDeclaredMethod("statusAutoChange", User.class);
            method.setAccessible(true);
            method.invoke(userController, correctUser);

            assertEquals(User.Status.Away, correctUser.getStatus());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            fail();
        }
    }

    @Test
    @DisplayName("statusAutoChange_lessTimeForSwitchAway_awayUserStatus")
    public void statusAutoChange_lessTimeForSwitchAway() {
        User correctUser = getNewCorrectUser();
        long currentTime = Calendar.getInstance().getTime().getTime();
        Date halfDelayTime = new Date(currentTime - autoChangeDelaySec*1000/2);
        correctUser.setLastActivity(halfDelayTime);
        correctUser.setStatus(User.Status.Away);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        try {
            Field autoChangeDelaySecField = UserController.class.getDeclaredField("autoChangeDelaySec");
            autoChangeDelaySecField.setAccessible(true);
            autoChangeDelaySecField.setInt(userController, autoChangeDelaySec);

            Method method = UserController.class.getDeclaredMethod("statusAutoChange", User.class);
            method.setAccessible(true);
            method.invoke(userController, correctUser);

            assertEquals(User.Status.Away, correctUser.getStatus());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            fail();
        }
    }

    @Test
    @DisplayName("statusAutoChange_moreTimeForSwitchAway_awayUserStatus")
    public void statusAutoChange_moreTimeForSwitchAway() {
        User correctUser = getNewCorrectUser();
        long currentTime = Calendar.getInstance().getTime().getTime();
        Date doubleDelayTime = new Date(currentTime - autoChangeDelaySec*1000*2);
        correctUser.setLastActivity(doubleDelayTime);
        correctUser.setStatus(User.Status.Away);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        try {
            Field autoChangeDelaySecField = UserController.class.getDeclaredField("autoChangeDelaySec");
            autoChangeDelaySecField.setAccessible(true);
            autoChangeDelaySecField.setInt(userController, autoChangeDelaySec);

            Method method = UserController.class.getDeclaredMethod("statusAutoChange", User.class);
            method.setAccessible(true);
            method.invoke(userController, correctUser);

            assertEquals(User.Status.Away, correctUser.getStatus());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            fail();
        }
    }

    @Test
    @DisplayName("statusAutoChange_lessTimeForSwitchOffline_offlineUserStatus")
    public void statusAutoChange_lessTimeForSwitchOffline() {
        User correctUser = getNewCorrectUser();
        long currentTime = Calendar.getInstance().getTime().getTime();
        Date halfDelayTime = new Date(currentTime - autoChangeDelaySec*1000/2);
        correctUser.setLastActivity(halfDelayTime);
        correctUser.setStatus(User.Status.Offline);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        try {
            Field autoChangeDelaySecField = UserController.class.getDeclaredField("autoChangeDelaySec");
            autoChangeDelaySecField.setAccessible(true);
            autoChangeDelaySecField.setInt(userController, autoChangeDelaySec);

            Method method = UserController.class.getDeclaredMethod("statusAutoChange", User.class);
            method.setAccessible(true);
            method.invoke(userController, correctUser);

            assertEquals(User.Status.Offline, correctUser.getStatus());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            fail();
        }
    }

    @Test
    @DisplayName("statusAutoChange_moreTimeForSwitchOffline_offlineUserStatus")
    public void statusAutoChange_moreTimeForSwitchOffline() {
        User correctUser = getNewCorrectUser();
        long currentTime = Calendar.getInstance().getTime().getTime();
        Date doubleDelayTime = new Date(currentTime - autoChangeDelaySec*1000*2);
        correctUser.setLastActivity(doubleDelayTime);
        correctUser.setStatus(User.Status.Offline);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);

        try {
            Field autoChangeDelaySecField = UserController.class.getDeclaredField("autoChangeDelaySec");
            autoChangeDelaySecField.setAccessible(true);
            autoChangeDelaySecField.setInt(userController, autoChangeDelaySec);

            Method method = UserController.class.getDeclaredMethod("statusAutoChange", User.class);
            method.setAccessible(true);
            method.invoke(userController, correctUser);

            assertEquals(User.Status.Offline, correctUser.getStatus());
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            fail();
        }
    }

    @Test
    @DisplayName("create_correctUser_okResponceEntity")
    public void create_correctUser() {
        User correctUser = getNewCorrectUser();
        ResponseEntity<?> okResponseEntity = new ResponseEntity<>(1, HttpStatus.CREATED);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.create(correctUser)).thenReturn(1);
        UserController userController = new UserController(userService);

        assertEquals(userController.create(correctUser), okResponseEntity);
    }

    @Test
    @DisplayName("create_incorrectUser_badReqstResponseEntity")
    public void create_incorrectUser() {
        User correctUser = getNewCorrectUser();
        ResponseEntity<?> badReqstResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.create(correctUser)).thenReturn(1);
        UserController userController = new UserController(userService);

        assertEquals(userController.create(getNewIncorrectUser()), badReqstResponseEntity);
    }

    @Test
    @DisplayName("read_correctId_okResponseEntity")
    public void read_correctId() {
        User correctUser = getNewCorrectUser();
        ResponseEntity<User> okResponseEntity = new ResponseEntity<>(correctUser, HttpStatus.OK);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.read(1)).thenReturn(java.util.Optional.of(correctUser));
        UserController userController = new UserController(userService);

        assertEquals(userController.read(1), okResponseEntity);
    }

    @Test
    @DisplayName("read_incorrectId_notFoundResponseEntity")
    public void read_incorrectId() {
        ResponseEntity<User> notFoundResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.read(1)).thenReturn(java.util.Optional.empty());
        UserController userController = new UserController(userService);

        assertEquals(userController.read(1), notFoundResponseEntity);
    }

    @Test
    @DisplayName("readEmpty_badRequestResponseEntity")
    public void readEmpty() {
        ResponseEntity<User> badRequestResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        assertEquals(userController.readEmpty(), badRequestResponseEntity);
    }

    @Test
    @DisplayName("updateStatus_correctIdAndNewStatusOnline_okResponseEntity")
    public void updateStatus_correctIdAndNewStatusOnline() {
        User correctUser = getNewCorrectUser();
        int id = correctUser.getId();
        String response = new JSONObject().append("id", id)
                                          .append("oldStatus", User.Status.Offline)
                                          .append("newStatus", User.Status.Online)
                                          .toString();

        ResponseEntity<?> okResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.read(id)).thenReturn(java.util.Optional.of(correctUser));
        UserController userController = new UserController(userService);

        assertEquals(userController.updateStatus(id, User.Status.Online), okResponseEntity);
    }

    @Test
    @DisplayName("updateStatus_incorrectIdAndNewStatusOnline_notFoundResponseEntity")
    public void updateStatus_incorrectIdAndNewStatusOnline() {
        User correctUser = getNewCorrectUser();
        int id = correctUser.getId();
        ResponseEntity<?> notFoundResponseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.read(id)).thenReturn(java.util.Optional.empty());
        UserController userController = new UserController(userService);

        assertEquals(userController.updateStatus(id, User.Status.Online), notFoundResponseEntity);
    }

    @Test
    @DisplayName("updateStatus_correctIdAndNewStatusAway_okResponseEntity")
    public void updateStatus_correctIdAndNewStatusAway() {
        User correctUser = getNewCorrectUser();
        int id = correctUser.getId();
        String response = new JSONObject().append("id", id)
                                          .append("oldStatus", User.Status.Offline)
                                          .append("newStatus", User.Status.Away)
                                          .toString();

        ResponseEntity<?> okResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.read(id)).thenReturn(java.util.Optional.of(correctUser));
        UserController userController = new UserController(userService);

        assertEquals(userController.updateStatus(id, User.Status.Away), okResponseEntity);
    }

    @Test
    @DisplayName("updateStatus_correctIdAndNewStatusOffline_okResponseEntity")
    public void updateStatus_correctIdAndNewStatusOffline() {
        User correctUser = getNewCorrectUser();
        int id = correctUser.getId();
        String response = new JSONObject().append("id", id)
                .append("oldStatus", User.Status.Offline)
                .append("newStatus", User.Status.Offline)
                .toString();

        ResponseEntity<?> okResponseEntity = new ResponseEntity<>(response, HttpStatus.OK);


        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.read(id)).thenReturn(java.util.Optional.of(correctUser));
        UserController userController = new UserController(userService);

        assertEquals(userController.updateStatus(id, User.Status.Offline), okResponseEntity);
    }

    @Test
    @DisplayName("updateStatusEmpty_badRequestResponseEntity")
    public void updateStatusEmpty() {
        ResponseEntity<?> badRequestResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        UserService userService = mock(UserService.class);
        UserController userController = new UserController(userService);
        assertEquals(userController.updateStatusEmpty(), badRequestResponseEntity);
    }

    private User getNewCorrectUser() {
        User correctUser = new User();
        correctUser.setId(1);
        correctUser.setUsername("manbearpig");
        correctUser.setEmail("manbear@pig.com");
        correctUser.setPhoneNumber("+7 (911) 123-1234");
        correctUser.setStatus(User.Status.Offline);
        correctUser.setLastActivity(Calendar.getInstance().getTime());
        return correctUser;
    }

    private User getNewIncorrectUser() {
        User incorrectUser = new User();
        incorrectUser.setId(1);
        incorrectUser.setUsername("кот");
        incorrectUser.setEmail("manbear@pig.com");
        incorrectUser.setPhoneNumber("+7 (911) 123-1234");
        incorrectUser.setStatus(User.Status.Offline);
        incorrectUser.setLastActivity(Calendar.getInstance().getTime());
        return incorrectUser;
    }
}
