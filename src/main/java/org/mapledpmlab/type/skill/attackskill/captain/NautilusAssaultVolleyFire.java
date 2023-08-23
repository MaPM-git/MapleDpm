package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NautilusAssaultVolleyFire extends AttackSkill {
    public NautilusAssaultVolleyFire() {
        this.setName("노틸러스 어썰트(일제 사격)");
        this.setDamage(660.0);
        this.setAttackCount(12L);
        this.setCooldown(180.0);
        this.setDotDuration(8000L);
        this.setInterval(222L);
        this.setLimitAttackCount(36L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new NautilusAssaultDelay());
    }
}
