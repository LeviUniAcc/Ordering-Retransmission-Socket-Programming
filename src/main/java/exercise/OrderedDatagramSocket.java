package exercise;

import main.DataMessage;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;

public class OrderedDatagramSocket extends DatagramSocket
{
    // Variables
    int nextSend = 0;
    int nextReceive = 0;
    List<DatagramPacket> receivedPackages = new ArrayList<>();
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
        if(!receivedPackages.contains(packet)){
            try {
                super.receive(packet);//?????????????????????
                if(DataMessage.demarshalling(packet.getData()).getID() != nextReceive){
                    receivedPackages.add(packet);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else{
            nextReceive++;
            //das packet zurückgeben??????
        }
    }

    /*
     * The functionality is described in the exercise sheet
     */
    @Override
    public void send(DatagramPacket packet) throws IOException
    {
        //TODO
        DataMessage message = new DataMessage(nextSend, packet.getData());
        nextSend++;
        packet.setData(DataMessage.marshalling(message));
        super.send(packet);
    }
}
