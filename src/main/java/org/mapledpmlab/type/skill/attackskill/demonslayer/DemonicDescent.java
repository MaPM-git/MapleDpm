package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonicDescent extends GaugeAttackSkill {
    public DemonicDescent() {
        this.setName("데모닉 디센트");
        this.setAttackCount(7L);
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(1990.0);
        this.setCooldown(20.0);
        this.getMultiAttackInfo().add(420L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
