namespace backend.Domain
{
    public class Models
    {
        public struct AddUserMessage
        {
            public int UserId;
            public bool Success;
            public string Message;
        }
    
        public class AddUserRequest
        {
            public string Name;
            public int Currency;
        }
    
        public class User
        {
            public int Id;
            public string Name;
            public int Currency;
        }
    }
    
}