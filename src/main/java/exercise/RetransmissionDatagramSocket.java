package exercise;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RetransmissionDatagramSocket extends DatagramSocket
{
    // Variables
    int timeout = 500;

    // Methods
    public RetransmissionDatagramSocket() throws SocketException
    {
    }

    protected RetransmissionDatagramSocket(DatagramSocketImpl datagramSocket)
    {
        super(datagramSocket);
    }

    public RetransmissionDatagramSocket(SocketAddress socketAddress) throws SocketException
    {
        super(socketAddress);
    }

    public RetransmissionDatagramSocket(int i) throws SocketException
    {
        super(i);
    }

    public RetransmissionDatagramSocket(int i, InetAddress inetAddress) throws SocketException
    {
        super(i, inetAddress);
    }

    /*
     * The functionality is described in the exercise sheet
     */
    @Override
    public void send(DatagramPacket datagramPacket) throws IOException
    {
        //TODO
    }

    /*
     * The functionality is described in the exercise sheet
     */
    @Override
    public void receive(DatagramPacket datagramPacket) throws IOException
    {
        //TODO
    }
}
