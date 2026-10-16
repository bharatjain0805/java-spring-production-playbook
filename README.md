# Java & Spring Boot Production Playbook

A production-grade implementation repository cataloging solutions to 200+ enterprise backend scenarios, multithreading coordination patterns, high-performance Java 8+ Stream pipelines, and core algorithmic problems.

---

## Architecture & Module Layout

```text
java-spring-production-playbook/
├── pom.xml                               # Spring Boot parent, Web, Data JPA, Redis, AOP, Test
├── README.md                             # Repository architecture and execution playbook
├── spring-scenarios/                     # Spring Boot architectural and production scenarios (1–56)
│   ├── config/                           # Dynamic strategy bean dispatching, conditional configs
│   ├── controller/                       # Stream responses, POST idempotency tokens, rate limiting
│   ├── service/                          # Transaction rollback traps, proxy bypass fixes, async workers
│   ├── repository/                       # N+1 query elimination (JOIN FETCH), soft deletes, cursor streaming
│   ├── exception/                        # Centralized @RestControllerAdvice, RFC 7807 ProblemDetail
│   └── aspect/                           # @Around AOP execution timers and metrics logging
├── core-java-scenarios/                  # Core Java enterprise scenarios (1–50)
│   ├── concurrency/                      # wait()/notify() alternating turns, Deadlock prevention, CompletableFuture
│   ├── collections/                      # LRU Cache (LinkedHashMap), Auto-suggest (TreeSet), custom HashMaps
│   └── patterns/                         # Strategy, Template Method, AutoCloseable resource management
├── streams-scenarios/                    # Java 8+ Streams scenarios (1–50)
│   ├── filtering/                        # Deduplication without distinct(), top-K, anagrams, reduce pipelines
│   └── aggregation/                      # Complex groupingBy, partitioning, and stats on Student/Employee/City models
└── dsa-solutions/                        # Optimized machine coding interview implementations
    ├── arrays/                           # 25 optimal Array solutions (Kadane's, Two-pointer, Sliding window)
    └── strings/                          # 25 optimal String solutions (KMP/strStr, Parentheses, Anagrams)
```

---

## Technical Highlights & Key Scenarios

### 1. Spring Boot Enterprise Resilience (`spring-scenarios/`)

- **Transaction Rollback Integrity (Scenario 32):** Addressed the CGLIB proxy self-invocation bypass where local method calls skip transactional interception, and added explicit `rollbackFor = Exception.class` to ensure rollbacks trigger on checked exceptions.
- **$N+1$ Query Elimination (Scenario 26):** Replaced default lazy-loading join patterns with JPQL `JOIN FETCH` and JPA `@EntityGraph` to fetch parent-child entity hierarchies in a single database round-trip.
- **Distributed POST Idempotency (Scenario 21):** Implemented an `Idempotency-Key` header validation mechanism backed by Redis atomic `SET NX` (`setIfAbsent`) with TTL to prevent duplicate order generation and race conditions.
- **High-Volume Data Streaming (Scenarios 41, 56):** Avoided JVM `OutOfMemoryError` on 1,000,000+ record exports by leveraging database cursor-backed `Stream<T>` execution combined with periodic Hibernate persistence context clearing (`flush()` and `clear()`).
- **Cross-Cutting Execution Profiling (Scenario 51):** Built an AspectJ `@Around` execution-timer aspect triggered via custom `@TrackExecutionTime` annotations for low-overhead latency telemetry.
- **Dynamic Bean Selection (Scenarios 14–17):** Implemented the Strategy Pattern using Spring's automatic map injection (`Map<String, PaymentStrategy>`) to dynamically select implementations at runtime without conditional branching.
- **Centralized API Error Schema (Scenario 52):** Standardized application exceptions into RFC 7807 `ProblemDetail` structures using `@RestControllerAdvice` and `@ExceptionHandler`.

### 2. Core Java & Concurrency (`core-java-scenarios/`)

- **Thread Turn Coordination (Scenarios 6, 7):** Coordinated deterministic thread interleaving (Odd/Even numbers and Alphanumeric sequences) using low-level monitor locks (`wait()` and `notify()`).
- **Producer-Consumer Coordination (Scenario 8):** Implemented bounded buffer patterns using both raw monitor synchronizations and concurrency primitives (`ArrayBlockingQueue`).
- **Deadlock Prevention (Scenario 9):** Demonstrated circular-wait deadlock conditions and eliminated them by enforcing strict, uniform resource lock ordering across competing worker threads.
- **Atomic State Updates (Scenario 10):** Prevented lost-update race conditions in multithreaded counters by replacing non-atomic primitives with lock-free `AtomicInteger` operations.
- **Asynchronous Composition (Scenario 12):** Executed multiple non-dependent service calls concurrently via `CompletableFuture.supplyAsync()` and merged outputs non-blockingly using `thenCombine()`.
- **LRU Cache Implementation (Scenario 33):** Subclassed `LinkedHashMap` configured with `accessOrder = true` and overridden `removeEldestEntry()` to build an in-memory cache with $O(1)$ lookup and eviction.
- **Auto-Suggest Prefix Search (Scenario 36):** Implemented prefix completion without full collection scanning by using `TreeSet.subSet()` range queries.
- **Custom Collections (Scenarios 47–50):** Built custom array-backed LIFO Stacks, circular FIFO Queues (`% capacity`), and a separate-chaining `CustomHashMap` supporting hash code distribution and collision handling.

### 3. Java 8+ Functional Pipelines (`streams-scenarios/`)

- **Stateful Deduplication (Scenarios 1, 2):** Isolated unique elements and extracted only duplicate items without calling `.distinct()` by configuring stateful `HashSet::add` filter predicates.
- **Ranking & Slicing (Scenarios 11, 12):** Extracted top-$K$ records and computed the $N^{\text{th}}$ highest distinct element using `.sorted()`, `.skip()`, and `.findFirst()` pipelines.
- **Text Analysis & Anagrams (Scenarios 8, 13, 22):** Checked string palindromes, solved anagram matching via sorted stream collectors, and determined longest common prefixes using binary `.reduce()` operations.
- **Entity Aggregations & Statistics (Scenarios 26–50):** Executed multi-level grouping, pass/fail boolean partitioning, and statistical salary summaries (`summarizingDouble()`) across Student, Employee, and City domain models.

### 4. Algorithmic Solutions (`dsa-solutions/`)

- **50 Optimized Implementations:** Solved the 25 Array and 25 String interview coding problems covering Kadane's algorithm, sliding window substring lookups, Dutch National Flag three-way partitioning, Floyd's cycle detection, and two-pointer expansions.

---

## Technology Stack

- **Language:** Java 17 / 21
- **Framework:** Spring Boot 3.2.x
- **Data Access:** Spring Data JPA, Hibernate, In-Memory H2 Database
- **Distributed Caching:** Spring Data Redis
- **Aspect-Oriented Programming:** Spring AOP / Aspect
- **Build System:** Apache Maven 3.8+

---

## Build & Local Verification

### Prerequisites

- JDK 17 or JDK 21 installed and configured in `$JAVA_HOME`
- Apache Maven 3.8+ installed (or use your IDE's embedded Maven runner)

### Commands

1. **Clone the repository:**

   ```bash
   git clone [https://github.com/YOUR_USERNAME/java-spring-production-playbook.git](https://github.com/YOUR_USERNAME/java-spring-production-playbook.git)
   cd java-spring-production-playbook
   ```

2. **Compile and verify the codebase:**

   ```bash
   mvn clean compile
   ```

3. **Execute automated tests:**

   ```bash
   mvn clean test
   ```

4. **Run the Spring Boot application:**
   ```bash
   mvn spring-boot:run
   ```

---

## Author & Attribution

Architected and maintained as a production-grade interview reference guide covering the _Java & Spring Knowledge Boost_ curriculum.
