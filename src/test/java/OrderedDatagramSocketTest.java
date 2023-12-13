import org.junit.Test;
import main.DataMessage;
import exercise.OrderedDatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import static junit.framework.TestCase.assertEquals;

public class OrderedDatagramSocketTest
{
    @Test
    public void testSocket() throws SocketException
    {
        DatagramSocket receiverSocket = new OrderedDatagramSocket();
        DatagramSocket senderSocket = new DatagramSocket();

        try
        {
            DataMessage dataMessage = new DataMessage(0, new byte[]{(byte)0, (byte)1, (byte)2, (byte)3, (byte)4});
            byte[] data = DataMessage.marshalling(dataMessage);
            senderSocket.send(new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));

            dataMessage = new DataMessage(4, new byte[]{(byte)4, (byte)1, (byte)2, (byte)3, (byte)4});
            data = DataMessage.marshalling(dataMessage);
            senderSocket.send(new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));

            dataMessage = new DataMessage(1, new byte[]{(byte)1, (byte)1, (byte)2, (byte)3, (byte)4});
            data = DataMessage.marshalling(dataMessage);
            senderSocket.send(new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));

            dataMessage = new DataMessage(2, new byte[]{(byte)2, (byte)1, (byte)2, (byte)3, (byte)4});
            data = DataMessage.marshalling(dataMessage);
            senderSocket.send(new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));

            dataMessage = new DataMessage(3, new byte[]{(byte)3, (byte)1, (byte)2, (byte)3, (byte)4});
            data = DataMessage.marshalling(dataMessage);
            senderSocket.send(new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));

            dataMessage = new DataMessage(5, new byte[]{(byte)5, (byte)1, (byte)2, (byte)3, (byte)4});
            data = DataMessage.marshalling(dataMessage);
            senderSocket.send(new DatagramPacket(data, data.length, InetAddress.getLoopbackAddress(), receiverSocket.getLocalPort()));

            for(int i = 0; i <= 5; i++)
            {
                byte[] recvBuffer = new byte[5];
                DatagramPacket packet = new DatagramPacket(recvBuffer, recvBuffer.length);
                System.out.println("Receiving: " + i);
                receiverSocket.receive(packet);

                System.out.println("Received: " + packet.getData()[0]);
                assertEquals(i, packet.getData()[0]);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
