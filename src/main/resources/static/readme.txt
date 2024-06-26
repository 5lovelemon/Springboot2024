/**
* 房間預訂系統(Web API)
*
*
* 房間資訊(Room)
* +--------+----------+---------------+
* | roomId | roomName |   roomSize    | 
* +--------+----------+---------------+
* |  101   |  101(1)  |  單人房sroom  |
  |  102   |  102(2)  |  雙人房droom  |
* +--------+----------+---------------+
*
* 
* 預定紀錄 (BookingRoom)
* +-----------+--------+--------+-------------+
* | bookingId | roomId | userId | bookingDate |
* +-----------+--------+--------+-------------+
* |     1     |   101  |   1    |  2024-07-05 |
* |     2     |   102  |   2    |  2024-07-06 |
* |     3     |   102  |   3    |  2024-06-31 |
* +-----------+--------+------ -+-------------+
*
*
*
*
* 功能要求:
* --------------------------------------------------------------------------
* 1.預訂房間:
* 路徑:/booking/bookRoom
* 參數:房間ID (roomId), 使用者ID (userId), 預定日期 (date)
* 返回:預定成功 (會得到預約號碼 bookingId) 或失敗的消息
* --------------------------------------------------------------------------
* 範例：http://localhost:8082/booking/bookRoom?roomId=101&userId=1&date=2023-12-04
*
* --------------------------------------------------------------------------
* 2.取消預訂:
* 路徑:/booking/cancelBooking/{bookingId}
* 參數:預定ID (bookingId)
* 返回:取消成功或失敗的消息
* --------------------------------------------------------------------------
* 範例：http://localhost:8082/booking/cancelBooking/1
*
* --------------------------------------------------------------------------
* 3.查看所有預訂:
* 路徑：/booking/viewBookings
* 返回：當前所有預訂的列表（可以簡單地返回字符串格式的預訂詳情） 
* --------------------------------------------------------------------------
* 範例：http://localhost:8082/booking/viewBookings
*
*----------------------------------------------------------------------------
* 4.修改預訂人
* 路徑：/booking/{bookingId}/updateUserId
* 返回：是否變更成功
* ---------------------------------------------------------------------------
* 範例：http://localhost:8082/booking/1/updateUserId?userId=2
* 範例：http://localhost:8082/booking/2/updateUserId?userId=3
* 
 
 
* 之後
* 我需要的功能
* 1. 餐點資訊 餐點名稱、描述、價格、圖片
* 2. 訂單資訊 訂單編號、訂購時間、付款狀態、送達地址
* 3. 顧客資訊 顧客姓名、電話號碼、電子郵件地址
* 4. 付款資訊 付款方式、付款金額、付款時間
* 5. 庫存資訊 庫存量，以確保不會超賣
* 6. 使用者資訊 系統需要使用者註冊或登入，則包括使用者帳戶資訊、密碼
**/