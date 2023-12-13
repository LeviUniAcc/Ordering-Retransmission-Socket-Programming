import org.junit.Test;
import main.DataMessage;
import solution.RetransmissionDatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class RetransmissionSocketTest
{
    @Test
    public void testSocket()
    {
        try
        {
            DatagramSocket senderSocket = new RetransmissionDatagramSocket();
            DatagramSocket receiverSocket = new DatagramSocket();

            senderSocket.send(new DatagramPacket(new byte[32], 32, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            receiverSocket.receive(packet);
            receiverSocket.setSoTimeout(500);
            byte[] dataRetransmission = new byte[1024];
            DatagramPacket retransmissionPacket = new DatagramPacket(dataRetransmission, dataRetransmission.length);
            receiverSocket.receive(retransmissionPacket);

            assertArrayEquals(DataMessage.demarshalling(packet.getData()).getData(), DataMessage.demarshalling(retransmissionPacket.getData()).getData());
        } catch (SocketException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
