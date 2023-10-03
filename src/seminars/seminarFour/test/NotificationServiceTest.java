import org.junit.jupiter.api.Test;
import seminars.seminarFour.main.MessageService;
import seminars.seminarFour.main.NotificationService;

import static org.mockito.Mockito.*;

class NotificationServiceTest {


    @Test
    public void sendMessageTest() {
        MessageService messageServiceMock = mock(MessageService.class);

        NotificationService notificationService = new NotificationService(messageServiceMock);
        notificationService.sendNotification("123456", "Илья");

        verify(messageServiceMock, times(1)).sendMessage("123456", "Илья");

    }
}