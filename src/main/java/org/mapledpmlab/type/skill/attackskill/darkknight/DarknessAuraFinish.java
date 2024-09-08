package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarknessAuraFinish extends AttackSkill {
    public DarknessAuraFinish() {
        this.setName("다크니스 오라(어둠의 참격)");
        this.setDamage(1350.0);
        this.setAttackCount(13L);
        this.setDelay(570L);
        this.addFinalDamage(1.6);   // 코어 강화
        this.getMultiAttackInfo().add(600L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
