package dto

class InputFormDto {
    public String FirstName, LastName, Email, Phone,
                  Address, City, State, ZipCode,
                  Website, Description
    public boolean Hosting

    static InputFormDto getDefault() {
        def inputForm = new InputFormDto()
        inputForm.FirstName = "Karel"
        inputForm.LastName = "Korinek"
        inputForm.Email = "karel.korinek@hotmail.com"
        inputForm.Phone = "+4604123456"
        inputForm.Address = "Private drive"
        inputForm.City = "New York"
        inputForm.State = "New York"
        inputForm.ZipCode = "10000"
        inputForm.Website = "nothing.now.com"
        inputForm.Hosting = false
        inputForm.Description = "Test DTO description"
        return inputForm
    }
}
