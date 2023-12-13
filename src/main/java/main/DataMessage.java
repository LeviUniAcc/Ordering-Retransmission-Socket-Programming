package main;

import java.io.*;

public class DataMessage implements Serializable
{
    ////////////////////
    //  DO NOT MODIFY //
    //   THIS FILE!   //
    ////////////////////

    /*
     * Converts a DataMessage object into a byte array
     * @param dataMessage the source DataMessage object
     * @return the serialized DataMessage object as byte array
     */
    public static byte[] marshalling(DataMessage dataMessage) throws IOException
    {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(65535);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteStream));
        objectOutputStream.writeObject(dataMessage);
        objectOutputStream.flush();

        return byteStream.toByteArray();
    }


    /*
     * Converts a byte array to a DataMessage
     * @param buffer the serialized DataMessage as byte array
     * @return the deserialized DataMessage object
     * @throws ClassNotFoundException if class DataMessage not found (should not be thrown in this context)
     * @throws EOFException if buffer does not contain a DataMessage object
     */
    public static DataMessage demarshalling(byte[] buffer) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(byteStream));
        DataMessage dataMessage = (DataMessage)objectInputStream.readObject();
        objectInputStream.close();

        return dataMessage;
    }

    private int ID;
    private int ackID;
    private byte[] data;

    /*
     * Creates a ACK message: ID is set to -1 and data to null
     * @param ackID ID of the packet to be ACKed
     */
    public DataMessage(int ackID)
    {
        this(-1,null, ackID);
    }

    /*
     * Creates a data message: ackID is set to -1
     * @param ID of the packet to be sent
     * @param data byte array containing the payload of the packet
     */
    public DataMessage(int ID, byte[] data)
    {
        this(ID, data,-1);
    }

    private DataMessage(int ID, byte[] data, int ackID)
    {
        this.ID = ID;
        this.ackID = ackID;
        this.data = data;
    }

    public int getID()
    {
        return ID;
    }

    public int getAckID()
    {
        return ackID;
    }

    public byte[] getData()
    {
        return data;
    }
}
