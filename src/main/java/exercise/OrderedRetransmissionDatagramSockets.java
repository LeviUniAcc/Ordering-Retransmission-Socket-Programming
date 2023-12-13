package exercise;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class OrderedRetransmissionDatagramSockets extends RetransmissionDatagramSocket
{
    // Variables
    int timeout = 500;

    // Methods
    public OrderedRetransmissionDatagramSockets() throws SocketException
    {
    }

    protected OrderedRetransmissionDatagramSockets(DatagramSocketImpl datagramSocket)
    {
        super(datagramSocket);
    }

    public OrderedRetransmissionDatagramSockets(SocketAddress socketAddress) throws SocketException
    {
        super(socketAddress);
    }

    public OrderedRetransmissionDatagramSockets(int i) throws SocketException
    {
        super(i);
    }

    public OrderedRetransmissionDatagramSockets(int i, InetAddress inetAddress) throws SocketException
    {
        super(i, inetAddress);
    }

    @Override
    public void receive(DatagramPacket datagramPacket) throws IOException
    {
        //TODO
    }

    @Override
    public void send(DatagramPacket datagramPacket) throws IOException
    {
        //TODO
    }

}
