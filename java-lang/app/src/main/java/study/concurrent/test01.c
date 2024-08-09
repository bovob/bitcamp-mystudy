#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    int i;
    pid_t processId;
    
    // 1. 부모 프로세스의 출력
    for (i = 0; i < 100; i++){
        printf("==> %d\n", i);
    }
    
    // 2. 프로세스 복제
    processId = fork();
    
    printf("-----------------\n");
    
    // 3. 자식과 부모 모두 실행되는 코드
    for (i = 0; i < 1000; i++){
        printf("%d: ~~~~> %d\n", processId, i);
    }
    
    return 0;
}
