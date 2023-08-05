package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetOption extends Item {

    public SetOption() {        // 4카 5아 9칠흑 2여명
        super();
        this.addMainStat(20L);  // 4카
        this.addSubStat(20L);
        this.addHp(1000L / 2);

        this.addAtt(50L);

        this.addBossDamage(30L);

        this.addHp(2000L / 2);  // 5아
        this.addAtt(30L);
        this.addMagic(30L);

        this.addMainStat(50L);
        this.addSubStat(50L);
        this.addOtherStat1(50L);
        this.addOtherStat2(50L);
        this.addAtt(35L);
        this.addMagic(35L);

        this.addAtt(40L);
        this.addMagic(40L);
        this.addIgnoreDefenseList(10L);

        this.addAtt(30L);
        this.addMagic(30L);
        this.addBossDamage(30L);

        this.addHp(250L / 2);   // 9칠흑
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(10L);
        this.addMagic(10L);
        this.addBossDamage(10L);

        this.addHp(250L / 2);
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(10L);
        this.addMagic(10L);
        this.addIgnoreDefenseList(10L);

        this.addHp(375L / 2);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addCriticalDamage(5.0);

        this.addHp(375L / 2);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addBossDamage(10L);

        this.addHp(375L / 2);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addIgnoreDefenseList(10L);

        this.addHp(375L / 2);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addCriticalDamage(5.0);

        this.addHp(375L / 2);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addBossDamage(10L);

        this.addHp(375L / 2);
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addOtherStat1(15L);
        this.addOtherStat2(15L);
        this.addAtt(15L);
        this.addMagic(15L);
        this.addCriticalDamage(5.0);
        
        this.addHp(250L / 2);   // 2여명
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(10L);
        this.addMagic(10L);
        this.addBossDamage(10L);
        
        this.addIgnoreDefenseList(10L);     // 칠요
    }
}
