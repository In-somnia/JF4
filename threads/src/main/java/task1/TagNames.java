package task1;


enum TagNames {
    TRANSACTIONS, TRANSACTION, DATE, VALUE, SENDER, RECEIVER, STATE;

    public static TagNames getTagName(String element)
    {
        switch(element)
        {
            case "transactions":
                return TRANSACTIONS;
            case "transaction":
                return TRANSACTION;
            case "date":
                return DATE;
            case "value":
                return VALUE;
            case "sender":
                return SENDER;
            case "receiver":
                return RECEIVER;
            case "state":
                return STATE;
            default:
                throw new EnumConstantNotPresentException(TagNames.class, element);
        }
    }
}

