package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdditionalDischarge extends AttackSkill {
    public AdditionalDischarge() {
        this.setName("에디셔널 디스차지");
        this.setAttackCount(3L);
        this.setDamage(266.0);          // 에인션트 아처리
        this.setProp(50L);              // 카디널 포스-에디셔널 인핸스
        this.setDotDuration(2000L);
        this.setInterval(100L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
    }
}
