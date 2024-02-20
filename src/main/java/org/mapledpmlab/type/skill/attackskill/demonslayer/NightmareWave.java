package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.buffskill.demonslayer.NightmareTerritory;

public class NightmareWave extends GaugeAttackSkill {
    public NightmareWave() {
        this.setName("나이트메어(파동)");
        this.setAttackCount(4L);
        this.addFinalDamage(0.9);       // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(3000.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
        this.setCooldown(360.0);
        this.setRelatedSkill(new NightmareTerritory());
        this.setGaugeCharge(-50.0);
        this.getMultiAttackInfo().add(1740L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
