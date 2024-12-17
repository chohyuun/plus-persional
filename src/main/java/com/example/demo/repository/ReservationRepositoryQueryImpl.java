package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.ReservationCond;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;
import java.util.Objects;

import static com.example.demo.entity.QReservation.reservation;

@RequiredArgsConstructor
public class ReservationRepositoryQueryImpl implements ReservationRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    private BooleanExpression userIdEq(Long userId) {
        return Objects.nonNull(userId) ? reservation.user.id.eq(userId) : null;
    }

    private BooleanExpression itemIdEq(Long itemId) {
        return Objects.nonNull(itemId) ? reservation.item.id.eq(itemId) : null;
    }

    @Override
    @EntityGraph(attributePaths = {"user", "item"})
    public List<Reservation> search(ReservationCond cond) {
        return queryFactory.selectFrom(reservation)
                .where(
                        userIdEq(cond.getUserId()),
                        itemIdEq(cond.getItemId())
                ).fetch();
    }
}
