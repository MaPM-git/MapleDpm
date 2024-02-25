package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonDive extends AttackSkill {
    public DragonDive() {
        this.setName("드래곤 다이브");
        this.setDamage(130.0 + 196);
        this.setAttackCount(3L);
        //this.setDotDuration(3500L);
        //this.setInterval(390L);
        //this.setLimitAttackCount(9L);
        this.setCooldown(6.0);          // 드래곤 다이브-쿨타임 리듀스
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(360L);
    }
}
