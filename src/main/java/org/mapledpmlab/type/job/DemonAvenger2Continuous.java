package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperDemonAvenger;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.IronWill;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DemonAvengerUnion;

import java.util.stream.Collectors;

public class DemonAvenger2Continuous extends Job {
    private Long starforce = 0L;

    public DemonAvenger2Continuous() {
        // 기본
        super();
        this.setName("데몬어벤져(2초, 컨티)");
        this.setConstant(1.3);          // 무기상수
        this.setMainStat((long) (4 + 40 + 5 + 30 + 6 + 6 + 6 + 6));
        this.setMastery(1.91 / 2);      // 숙련도
        this.addMainStatP(10L);         // 4카루타 세트
        this.setJobType(JobType.DEMON_AVENGER);
        this.addHp(this.getAp());

        this.setAscentDamage(2918615.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 145));
        passive.addSubStat((long) (145));
        passive.addHp((long) (2800 + 1855) / 2);
        passive.addAtt((long) (340 + 210 + 72 + 253));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addHp(560L / 2);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("심볼");
        passive.addPerXMainStat(-28200L);
        passive.addPerXMainStat(277200L + 315000);
        getPassiveList().add(passive);

        this.starforce += 22 * 16;      // 22성 장비
        this.starforce += 15;           // 블랙하트

        passive = new Common();
        passive.setDescription("컨버전 스타포스");
        if (this.starforce >= 361 && this.starforce <= 370) {
            passive.addHp(this.starforce * 160);
        } else if (this.starforce >= 371 && this.starforce <= 380) {
            passive.addHp(this.starforce * 162);
        } else if (this.starforce >= 381 && this.starforce <= 390) {
            passive.addHp(this.starforce * 164);
        } else if (this.starforce >= 391 && this.starforce <= 400) {
            passive.addHp(this.starforce * 166);
        } else if (this.starforce >= 401) {
            passive.addHp(this.starforce * 168);
        }
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("데모닉 샤프니스");
        passive.addCriticalP(15.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("데몬 액셀레이션");
        passive.addHp(400L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어비셜 레이지");
        passive.addAtt(40L);
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("이너 스트렝스");
        passive.addHp(600L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("디아볼릭 리커버리");
        passive.addMainStatP(25L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("메이플 용사");
        passive.addMainStatP(15L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("오버휄밍 파워");
        passive.addFinalDamage(1.15);
        passive.addDamage(31L);
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("디펜스 엑스퍼타이즈");
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 데스페라도 마스터리");
        passive.addAtt(51L);
        passive.addCriticalDamage(8.0);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addHp(1500L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 하이퍼 바디");
        passive.addMainStatP(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("쓸만한 어드밴스드 블레스");
        passive.addHp(475L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-36L);
        this.addAtt(1L);
        this.addMainStat(10L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new IronWill());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DemonAvengerUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperDemonAvenger(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("향상된 10단계 물약");
        doping.addMainStat(-30L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("익스트림 골드");
        doping.addHp(2000L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("메이플 용사(콜렉터의 영약)");
        doping.addMainStatP(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("오버휄밍 파워(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 데스페라도 마스터리(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getTotalHp() {
        return (long) Math.floor(this.getHp() * (1 + this.getMainStatP() * 0.01)) + this.getPerXMainStat();
    }

    public Long getFinalHp() {
        return (long) Math.floor((double) this.getAp() / 3.5)
                + (long) Math.floor(
                        (long) Math.floor((this.getTotalHp() - this.getAp()) / 3.5) * 0.8
        );
    }

    public Long getFinalHpHyperBodyX() {
        return (long) Math.floor(
                (this.getAp() / 14 + this.getHp() / 17.5)
                * (1 + (this.getMainStatP() - 40) * 0.01)
                + this.getPerXMainStat() / 17.5
        );
    }

    public Long getStr() {
        return (long) Math.floor(
                this.getMainStat()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXSubStat();
    }

    public Long getAp() {
        return this.getLevel() * 90 + 545;
    }

    public Long getStatDamage() {
        return (long) (Math.floor(
                this.getFinalHp() //* 4
                + this.getStr()) * 0.01
                * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                * this.getConstant()
                * (1 + this.getDamage() * 0.01)
                * this.getFinalDamage()
        );
    }

    @Override
    public Object[] getOpject() {
        Long attMagicBase;
        Long attMagicP;
        Long attMagicAbs;
        Long statusAdditionalDmg;
        if (this.getAtt() > this.getMagic()) {
            attMagicBase = this.getAtt();
            attMagicP = this.getAttP();
            attMagicAbs = this.getPerXAtt();
        } else {
            attMagicBase = this.getMagic();
            attMagicP = this.getMagicP();
            attMagicAbs = this.getPerXAtt();
        }
        if (this.getAbilityDescription().contains("상태")) {
            statusAdditionalDmg = 14L;
        } else {
            statusAdditionalDmg = 6L;
        }
        Object[] result = new Object[]{
                this.getName(), this.getConstant(), this.getMastery() * 2 - 1, this.getLevel(),
                this.getHp(), this.getMainStatP() + this.getAllStatP(), this.getPerXMainStat(),
                this.getSubStat(), this.getAllStatP(), this.getPerXSubStat(), "X", "X", "X", this.getStatDamage(),
                this.getDamage(), String.format("%.2f", this.getFinalDamage() * 100 - 100), this.getBossDamage(),
                String.format("%.4f", this.getIgnoreDefense() * 100), attMagicBase, attMagicP, attMagicAbs, this.getCriticalP(), this.getCriticalDamage(),
                this.getCooldownReductionSec() + "초 / " + this.getCooldownReductionP() + "%", this.getPlusBuffDuration(), this.getReuse(),
                this.getProperty(), statusAdditionalDmg, "30", "1350", "660", this.getWeaponAttMagic()
        };
        return result;
    }
}
