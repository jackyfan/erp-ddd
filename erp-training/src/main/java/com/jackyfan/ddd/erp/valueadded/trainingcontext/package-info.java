
@BoundedContext(name = "training", subDomain = SubDomain.Core)
package com.jackyfan.ddd.erp.valueadded.trainingcontext;
/**
 订单限界上下文
 对于培训票{@link com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Ticket Ticket}
 ，培训专员可以将票“分配”给部门协调者，部门协调者在得到票后，又可以将票再“分配”给别的协调者，也可以将票直接“分配”给员工。
 虽然都是在“分配”票，含义却完全不同。为避免这两个概念的混淆，可以将票直接分配给员工的操作视为对员工的提名（Nomination）。
 于是明确了如下概念：
 分配票给协调者（Assign ticket to coordinator）：获得票的员工为协调者，并非参加培训的员工
 提名员工{@link com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Nominator Nominator}：意味着将票分给员工，使得他具备了参加培训的资格
 对于部门的员工而言，在不同场景也具有不同的身份，体现了员工与培训的不同关系：
 候选人{@link com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.candidate.Candidate Candidate}
 ：利用过滤器删选或直接添加的员工，都是培训的候选人。这些候选人具备被培训专员或协调者提名参加培训的资格，但并不意味着候选人已经被提名了。
 被提名人{@link com.jackyfan.ddd.erp.valueadded.trainingcontext.domain.ticket.Nominee Nominee}：指获得培训票要求参加培训的员工，即被提名的对象。
 备选人（Backup）：提名候选名单中剔除掉已经被提名的员工列表。
 学员（Trainee）：被提名人在收到培训票后确认参加，就会成为该培训的学员。
 */

import com.jackyfan.ddd.core.stereotype.BoundedContext;
import com.jackyfan.ddd.core.stereotype.SubDomain;