package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdditionalDischargeFirst extends AttackSkill {
    public AdditionalDischargeFirst() {
        this.setName("에디셔널 디스차지(첫타)");
        this.setAttackCount(3L);
        this.setDamage(275.0 + 66);     // 에인션트 아처리
        this.setProp(55L);              // 카디널 포스-에디셔널 인핸스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
        this.setRelatedSkill(new AdditionalDischargeAfterSecond());
    }
}
