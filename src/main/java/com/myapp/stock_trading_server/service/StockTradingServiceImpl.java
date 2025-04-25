package com.myapp.stock_trading_server.service;

import com.myapp.stock_trading_server.entity.Stock;
import com.myapp.stock_trading_server.grpc.StockRequest;
import com.myapp.stock_trading_server.grpc.StockResponse;
import com.myapp.stock_trading_server.grpc.StockTradingServiceGrpc;
import com.myapp.stock_trading_server.repository.StockRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class StockTradingServiceImpl extends StockTradingServiceGrpc.StockTradingServiceImplBase {

    private final StockRepository stockRepository;

    @Override
    public void getStockPrice(StockRequest request, StreamObserver<StockResponse> responseObserver) {

        String stockSymbol = request.getStockSymbol();
        Stock stock = stockRepository.findByStockSymbol(stockSymbol);

        StockResponse stockResponse = StockResponse.newBuilder()
                .setStockSymbol(stock.getStockSymbol())
                .setPrice(stock.getPrice())
                .setTimestamp(stock.getLastUpdated().toString())
                .build();

        responseObserver.onNext(stockResponse);
        responseObserver.onCompleted();
    }
}
