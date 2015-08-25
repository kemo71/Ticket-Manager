package org.mohammad.ticket.repository;
import org.mohammad.ticket.orm.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface TaskRepository extends PagingAndSortingRepository<Task,Long>{
}
