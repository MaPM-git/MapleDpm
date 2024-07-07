package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EndlessDarkness extends AttackSkill {
    public EndlessDarkness() {
        this.setName("엔드리스 다크니스");
        this.setDamage(1580.0);
        this.setAttackCount(5L * 2);
        this.addFinalDamage(0.75);
        this.addFinalDamage(1.05);  // 어둠 마법 강화
        this.getMultiAttackInfo().add(300L);
        this.setCooldown(2.0);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
