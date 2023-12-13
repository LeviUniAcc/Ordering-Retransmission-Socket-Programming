package exercise;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;

public class OrderedDatagramSocket extends DatagramSocket
{
    // Variables

    // Methods
    public OrderedDatagramSocket() throws SocketException
    {
    }

    protected OrderedDatagramSocket(DatagramSocketImpl impl)
    {
        super(impl);
    }

    public OrderedDatagramSocket(SocketAddress bindaddr) throws SocketException
    {
        super(bindaddr);
    }

    public OrderedDatagramSocket(int port) throws SocketException
    {
        super(port);
    }

    public OrderedDatagramSocket(int port, InetAddress laddr) throws SocketException
    {
        super(port, laddr);
    }

    /*
     * The functionality is described in the exercise sheet
     */
    @Override
    public void receive(DatagramPacket packet) throws IOException
    {
        //TODO
    }

    /*
     * The functionality is described in the exercise sheet
     */
    @Override
    public void send(DatagramPacket packet) throws IOException
    {
        //TODO
    }
}
